package dao;

/**
 *
 * @author XU3N
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Category;
import model.Product;

public class ProductDao {

    public static void saveProduct(Product product) throws SQLException {
        PreparedStatement stmt1 = DatabaseConnect.dbconn().prepareStatement("INSERT INTO product(product_name, category, price)"
                + "VALUES (?,?,?)");
        stmt1.setString(1, product.getName());
        stmt1.setString(2, product.getCategory());
        stmt1.setString(3, product.getPrice());
        DbOperations.setDataOrDelete(stmt1, "Product Added Successfully!");
    }
    
    public static ArrayList<Product> getAllRecords() {
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            PreparedStatement stmt2 = DatabaseConnect.dbconn().prepareStatement("SELECT * FROM product");
            ResultSet rs = DbOperations.getData(stmt2);
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getString("product_id"));
                product.setName(rs.getString("product_name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));
                arrayList.add(product);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
        }
        return arrayList;
    }

    public static Product checkRecord(String name, String category) {
        Product product = null;
        try {
            PreparedStatement stmt2 = DatabaseConnect.dbconn().prepareStatement("SELECT product_name FROM product WHERE category = ?");
            stmt2.setString(1, name);
            ResultSet rs = DbOperations.getData(stmt2);
            if (rs.next()) {
                product = new Product();
                product.setId(rs.getString("product_id"));
                product.setName(rs.getString("product_name"));
            }
        } catch (SQLException e) {
            // Let the caller handle the exception
            e.printStackTrace();
        }
        return product;
    }
    
    public static Product searchRecord(String id) {
        Product product = new Product();
        try {
            PreparedStatement stmt3 = DatabaseConnect.dbconn().prepareStatement("SELECT * FROM product WHERE product_id = '" + id + "'");
            ResultSet rs = DbOperations.getData(stmt3);
            while (rs.next()) {
                product.setId(rs.getString("product_id"));
                product.setName(rs.getString("product_name"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return product;
    }

    public static void updateProduct(Product product) throws SQLException {
        PreparedStatement stmt3 = DatabaseConnect.dbconn().prepareStatement("UPDATE product SET product_name = ? AND category = ? AND price = ? WHERE product_id = ?");
        stmt3.setString(1, product.getName());
        stmt3.setString(2, product.getCategory());
        stmt3.setString(3, product.getPrice());
        stmt3.setString(4, product.getId());

        DbOperations.setDataOrDelete(stmt3, "Product Updated Successfully!");

    }

    public static void deleteProduct(String id) throws SQLException {
        PreparedStatement stmt4 = DatabaseConnect.dbconn().prepareStatement("DELETE FROM product WHERE product _id = ?");
        stmt4.setString(1, id);
        DbOperations.setDataOrDelete(stmt4, "Product Deleted Successfully!");
    }
}
