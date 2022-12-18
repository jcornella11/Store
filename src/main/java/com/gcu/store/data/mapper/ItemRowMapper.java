package com.gcu.store.data.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.gcu.store.data.entity.ItemEntity;
import org.springframework.jdbc.core.RowMapper;

public class ItemRowMapper implements RowMapper <ItemEntity> {

    @Override
    public ItemEntity mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        return new ItemEntity(
                rs.getLong("ID"),
                rs.getString("NAME"),
                rs.getString("DESCRIPTION"),
                rs.getInt("SKU"),
                rs.getInt("QUANTITY"),
                rs.getDouble("PRICE")
        );
    }

}
