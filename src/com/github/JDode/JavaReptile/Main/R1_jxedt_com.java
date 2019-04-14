package com.github.JDode.JavaReptile.Main;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;

import com.alibaba.fastjson.JSONObject;
import com.github.JDode.JavaReptile.model.Table01;
import com.github.JDode.JavaReptile.utils.ConsoleLog;
import com.github.JDode.JavaReptile.utils.HttpClient;
import com.github.JDode.JavaReptile.utils.JDBCUtil;

/**
 * Created by Ding on 2019/4/13 2:59 PM.
 *
 * @Description: 爬取
 *               http://mnks.jxedt.com/get_question?r=0.04581873948117421&index=1111
 *               <p>
 *               <a href="https://github.com/JDode">to see GitHub</a>
 */
public class R1_jxedt_com {

	private String Path = "src/config/jdbc.properties";

	Statement st = null;

	public static void main(String[] args) throws Exception {

		/**
		 * 就测试了一遍能正常爬取，如果发现有bug自己改吧
		 */

		new R1_jxedt_com().ReptileService(1, 3933);

	}

	private void ReptileService(int start, int count) throws SQLException, MalformedURLException, IOException {

		long starTime = System.currentTimeMillis();

		// HttpClient httpClient = new
		// HttpClient().init("http://mnks.jxedt.com/get_question?r=0.04581873948117421&index=2");
		Connection connection = JDBCUtil.init(Path).getConnection();
		if (connection != null) {
			ConsoleLog.info("SQLConnection获取正常:" + connection);
		} else {
			ConsoleLog.error("SQLConnection获取异常！！！");
		}
		st = connection.createStatement();
		int num = 0;

		// 这里注意你数据库最后一条记录次数 这样方便你后期你继续爬取数据库在原数据库记录上累加
		// start 从条记录开始
		// count 需要再爬取多少条记录

		for (int i = start; i <= count; i++) {
			// 通过阿里fastjson 把http得到的json字符串反射一个Java实体对象
			Table01 t = JSONObject
					.parseObject(HttpClient.get("http://mnks.jxedt.com/get_question?r=0.04581873948117421&index=" + i)
							.replaceAll("/", "//").replaceAll("\\\\", "\\\\\\\\"), Table01.class);

			// System.out.println(t.toString());
			if (t == null) {
				ConsoleLog.error("阿里fastjson反射实体对象异常！！");
				return;
			}
			//下载题目中的素材图片
			if ((!t.getImageurl().equals(""))) {
				// http://img.58cdn.com.cn/dist/jxedt/app/static/img/kaoshi_p/5eb4d75agw1e28yntci5ej.jpg
				String[] urls = t.getImageurl().split("\\.");
				ConsoleLog.info(Arrays.toString(urls));
				//是视频就下载视频
				if (urls[1].equals("mp4")) {
					String imageUrl = "http://img.58cdn.com.cn/dist/jxedt/app/static/img/kaoshi_p/" + urls[0] + ".mp4";
					FileUtils.copyURLToFile(new URL(imageUrl), new File("src/images/" + urls[0] + ".mp4"));
				}
				//是图片文件就下载图片
				if (urls[1].equals("webp")) {
					String imageUrl = "http://img.58cdn.com.cn/dist/jxedt/app/static/img/kaoshi_p/" + urls[0] + ".jpg";
					FileUtils.copyURLToFile(new URL(imageUrl), new File("src/images/" + urls[0] + ".jpg"));
				}
			}
			// 创建SQL
			String sql = String.format(
					"insert into Table01 values(%d,'%s','%s','%s','%s','%s',%d,'%s','%s','%s',%d,'%s')", i,
					t.getQuestion(), t.getA(), t.getB(), t.getC(), t.getD(), t.getTa(), t.getImageurl(),
					t.getBestanswer(), t.getBestanswerid(), t.getType(), t.getSinaimg());

			ConsoleLog.info("第" + (++num) + "次爬取 <==> SQL语句创建完成:\n" + sql);

			// 4、执行语句
			int row = st.executeUpdate(sql);
			// 如果row不等于1说明程序在操作数据库发生错误，方便记录成功爬取的数据条数
			if (row != 1) {
				num--;
			}

		}
		ConsoleLog.info("程序爬取完成!成功爬取:" + num + "记录!花费时间为" + (System.currentTimeMillis() - starTime) + "ms");
		//new JDBCUtil();
		// 数据爬取并且存储完成关闭数据库连接
		JDBCUtil.closeConnection(connection);

	}

}
