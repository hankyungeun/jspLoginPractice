package com.kh.service;

import com.kh.dao.MemberDao;
import com.kh.vo.Member;
import static com.kh.common.JDBCTemplate.*;
import java.sql.*;

public class MemberService {
    public Member loginMember(String userId, String userPwd) {
        Connection conn = getConnection();

        Member loginUser = new MemberDao().loginMember(conn, userId, userPwd);
        close(conn);

        return loginUser;
    }

    public int insertMember(Member m) {
        Connection conn = getConnection();

        int result = new MemberDao().insertMember(conn, m);

        if (result > 0) {
            commit(conn);
        } else {
            rollback(conn);
        }

        close(conn);

        return result;
    }
}
