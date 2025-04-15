package com.sports.life.config.TypeHandler;

import com.sports.life.entity.GeoPoint;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * point类型数据新增到mysql中用到的自定义jdbcType处理器
 */
@MappedTypes(GeoPoint.class)
public class GeomPointTypeHandler extends BaseTypeHandler<GeoPoint> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, GeoPoint geoPoint, JdbcType jdbcType) throws SQLException {
        ps.setString(i, geoPoint.toString());
    }

    @Override
    public GeoPoint getNullableResult(ResultSet re, String s) throws SQLException {
        System.out.println("getNullableResult开始执行： ");
        String reString = re.getString(s);
        if(reString == null){
            return null;
        }
        String[] split = reString.replace("POINT(", "").replace(")", "").split(" ");
        double longitude  = Double.parseDouble(split[0]);
        double latitude = Double.parseDouble(split[1]);

        return new GeoPoint(longitude,latitude);
    }

    @Override
    public GeoPoint getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("执行了getNullableResult");
        String reString = rs.getString(columnIndex);
        if (reString == null) {
            return null;
        }
        String[] parts = reString.replace("POINT(", "").replace(")", "").split(" ");
        double longitude = Double.parseDouble(parts[0]);
        double latitude = Double.parseDouble(parts[1]);
        return new GeoPoint(longitude, latitude);

    }

    @Override
    public GeoPoint getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("执行了getNullableResult");
        String reString = cs.getString(columnIndex);
        if (reString == null) {
            return null;
        }
        String[] parts = reString.replace("POINT(", "").replace(")", "").split(" ");
        double longitude = Double.parseDouble(parts[0]);
        double latitude = Double.parseDouble(parts[1]);
        return new GeoPoint(longitude, latitude);

    }
}
