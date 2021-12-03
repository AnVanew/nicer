package utill;

public class Queries {
    public final static String SELECT_ALL_MONEY_BY_ID_QUERY = "SELECT * FROM MONEYS WHERE USER_ID = ?";
    public final static String INSERT_MONEY_QUERY = "INSERT INTO moneys (category, number, date, user_id) VALUES (?, ?, ?, ?)";
    public final static String DELETE_MONEY_BY_ID_QUERY = "DELETE FROM moneys WHERE id = ?";
}
