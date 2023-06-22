package sg.edu.nus.iss.day23workshop.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.day23workshop.model.FullOrder;

@Repository
public class FullOrderRepo {

    @Autowired
    JdbcTemplate template;

    private final String querySQL = "SELECT o.id, o.order_date, o.customer_id as customerID, (od.quantity * od.unit_price * (1 - od.discount)) AS total_price, (od.quantity * p.standard_cost) AS cost_price\n" + //
            "FROM orders AS o\n" + //
            "INNER JOIN order_details AS od ON o.id = od.order_id\n" + //
            "INNER JOIN products AS p ON od.product_id = p.id\n" + //
            "WHERE o.id = ?;";

    public List<FullOrder> findAll(int orderID) {
        return template.query(querySQL, BeanPropertyRowMapper.newInstance(FullOrder.class), orderID);
    }
    
}
