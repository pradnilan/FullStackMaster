package com.simplilearn.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EProductDao {
    @Autowired
    private JdbcTemplate template;

    public List<EProductEntity> getAllProducts(){
        return template.query("select * from eproduct",
                new RowMapper<EProductEntity>() {
                    @Override
                    public EProductEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

                        EProductEntity eProduct=new EProductEntity();
                        eProduct.setId(rs.getLong(1));
                        eProduct.setName(rs.getString(2));
                        eProduct.setPrice(rs.getBigDecimal(3));
                        eProduct.setDateAdded(rs.getTimestamp(4));

                        return eProduct;
                    }
                });
    }

    public EProductEntity getProductById(long id){
        return template.query("select * from eproduct where id=" + id, new ResultSetExtractor<EProductEntity>() {
            @Override
            public EProductEntity extractData(ResultSet rs) throws SQLException, DataAccessException {
                if(rs.next()){
                    EProductEntity entity=new EProductEntity();
                    entity.setId(rs.getLong(1));
                    entity.setName(rs.getString(2));
                    entity.setPrice(rs.getBigDecimal(3));
                    entity.setDateAdded(rs.getTimestamp(4));

                    return entity;
                }
                return null;
            }
        });

    }

    public int updateProduct(EProductEntity entity){
        String sql="update eproduct set name=?,price=?,date=? where id=?";
        return template.update(sql,entity.getName(),entity.getPrice(),entity.getDateAdded(),entity.getId());
    }

}
