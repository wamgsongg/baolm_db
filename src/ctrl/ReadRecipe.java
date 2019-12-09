package ctrl;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Recipe;
import test.DBUtil;
import test.ImageUtil;

public class ReadRecipe extends ReadFile{
	public static void addRecipe(Recipe recipe) {
        String path = recipe.getRecipepath();
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream in = null;
        try {
            in = ImageUtil.readImage(path);
            conn = DBUtil.getConnection();
            String sql = "insert into recipe (recipe_id,shop_id,recipe_name,recipe_price,monthly_sale,recipe_notice,recipe_image,recipe_remain,recipe_discount,recipe_status) "
            		+ "values(?,?,?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, recipe.getRecipeid());
            ps.setInt(2,recipe.getShopid());
            ps.setString(3,recipe.getRecipename());
            ps.setDouble(4, recipe.getRecipeprice());
            ps.setInt(5, recipe.getMonthlysale());
            ps.setString(6, recipe.getRecipenotice());
       
            ps.setBinaryStream(7, in, in.available());
            ps.setInt(8, recipe.getReciperemain());
            ps.setDouble(9, recipe.getRecipediscount());
            ps.setString(10, recipe.getRecipestatus());
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

}
