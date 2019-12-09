package test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Administrator 测试写入数据库以及从数据库中读取
 */
public class ImageDemo {

    // 将图片插入数据库
    public static void readImage2DB() {
        String path = "D:/1.jpg";
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream in = null;
        try {
            in = ImageUtil.readImage(path);
            conn = DBUtil.getConnection();
            String sql = "insert into recipe (recipe_id,shop_id,recipe_name,recipe_price,monthly_sale,recipe_notice,recipe_image,recipe_remain,recipe_discount,recipe_status) "
            		+ "values(?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, 6);
            ps.setInt(2, 1);
            ps.setString(3, "小笼包");
            ps.setDouble(4, 2.5);
            ps.setInt(5, 60);
            ps.setString(6, "新鲜小笼包");
       
            ps.setBinaryStream(7, in, in.available());
            ps.setInt(8, 11);
            ps.setDouble(9, 0.8);
            ps.setString(10, "正常");
            int count = ps.executeUpdate();
            if (count > 0) {
                System.out.println("插入成功！");
            } else {
                System.out.println("插入失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn);
            if (null != ps) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // 读取数据库中图片
    public static void readDB2Image() {
        String targetPath = "D:/image/2.jpg";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from recipe where recipe_id =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 5);
            rs = ps.executeQuery();
            while (rs.next()) {
                InputStream in = rs.getBinaryStream("recipe_image");
                ImageUtil.readBin2Image(in, targetPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConn(conn);
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    //测试
    public static void main(String[] args) {
        //readImage2DB();
        readDB2Image();
    }
}