package com.kh.dao;
import static com.kh.common.JDBCTemplate.close;
import com.kh.vo.Member;

import java.io.*;
import java.sql.*;
import java.util.*;

public class MemberDao {
    Properties prop = new Properties();
    // 생성자 부분에 xml 파일을 연결
    public MemberDao() {

        String filepath = MemberDao.class.getResource("/db/sql/Member.xml").getPath();

        try {
            prop.loadFromXML(new FileInputStream(filepath));
        } catch (InvalidPropertiesFormatException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Member loginMember(Connection conn, String id, String passwd) {
        Member loginUser = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String sql = prop.getProperty("login");

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, id);
            pstmt.setString(2, passwd);

            rset = pstmt.executeQuery();
            // => 조회 결과가 있으면 한 행이 반환 또는 조회 결과가 없으면 아무것도 반환되지 않을 것임
            if(rset.next()) {
                loginUser = new Member(
                        rset.getString("id"),
                        rset.getString("passwd"),
                        rset.getString("name"),
                        rset.getString("phone")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rset);
            close(pstmt);
        }

        return loginUser;
    }

    public int insertMember(Connection conn, Member m) {
        int result = 0;
        PreparedStatement pstmt = null;

        String sql = prop.getProperty("insertMember");

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, m.getId());
            pstmt.setString(2, m.getPasswd());
            pstmt.setString(3, m.getName());
            pstmt.setString(4, m.getPhone());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }
}
