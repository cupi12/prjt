package co.yedam.app.member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.yedam.app.common.ConnectionManager;

public class MemberDAO {

	public int memberInsert(MemberVO member) {
		int r = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "insert into member (id, pwd, name, hobby, gender, religion, introduction, regdt)"
					+ " values ( ?, ?, ?, ?, ?, ?, ?, sysdate)";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPwd());
			psmt.setString(3, member.getName());
			psmt.setString(4, member.getHobby());
			psmt.setString(5, member.getGender());
			psmt.setString(6, member.getReligion());
			psmt.setString(7, member.getIntroduction());

			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 등록됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

		return r;
	}// end of insert

	public ArrayList<MemberVO> getMemberList(int start, int end, String id, String name) { //전체조회 + 회원검색해서 조회
		String strWhere = " where 1 = 1";
		if (id != null && !id.isEmpty()) {
			strWhere += " and id = ?";
		}
		if (name != null && !name.isEmpty()) {
			strWhere += " and name like '%' || ? || '%'";
		}
		Connection conn = null;
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {
			// 1. DB연결
			PreparedStatement psmt = null;
			// 2. 쿼리 준비
			conn = ConnectionManager.getConnnect();
			String sql = "select B.* from (select A.*, rownum rn from ("
					+ "select * FROM member"+  strWhere+ "order by id"
							+ "  ) A  )B where rn between ? and ?  "; //strWhere 넣어 줘야함
			psmt = conn.prepareStatement(sql);
			// 3. statement 실행
			int position = 1;
			if (id != null && !id.isEmpty()) {
				psmt.setString(position++, id);
			}
			if (name != null && !name.isEmpty()) {
				psmt.setString(position++, name);
			}
			psmt.setInt(position++, start);
			psmt.setInt(position, end);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setHobby(rs.getString("hobby"));
				vo.setGender(rs.getString("gender"));
				vo.setReligion(rs.getString("religion"));
				vo.setIntroduction(rs.getString("introduction"));
				vo.setRegdt(rs.getString("regdt"));
				list.add(vo);
			}
			// 4. 결과 저장
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
			// 5. 연결 해제
		}
		return list;
	}

	public MemberVO getMember(String id) {// 단건조회
		MemberVO vo = new MemberVO();
		try {
			// 1. DB연결
			Connection conn = null;
			PreparedStatement psmt = null;
			// 2. 쿼리 준비
			conn = ConnectionManager.getConnnect();
			String sql = "select * FROM member where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			// 3. statement 실행
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setHobby(rs.getString("hobby"));
				vo.setGender(rs.getString("gender"));
				vo.setReligion(rs.getString("religion"));
				vo.setIntroduction(rs.getString("introduction"));
				vo.setRegdt(rs.getString("regdt"));
			} else {

			}
			// 4. 결과 저장
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결 해제
		}
		return vo;
	}

	public int memberUpdate(MemberVO member) {
		int r = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		try {
			// 1. DB 연결
			conn = ConnectionManager.getConnnect();

			// 2. sql구문 준비
			String sql = "update member set pwd =?, name =?, hobby=?, gender =?, religion=?, introduction=? where id =? ";

			psmt = conn.prepareStatement(sql);

			// 3. 실행
			psmt.setString(1, member.getPwd());
			psmt.setString(2, member.getName());
			psmt.setString(3, member.getHobby());
			psmt.setString(4, member.getGender());
			psmt.setString(5, member.getReligion());
			psmt.setString(6, member.getIntroduction());
			psmt.setString(7, member.getId());

			r = psmt.executeUpdate();

			// 4. 결과처리
			System.out.println(r + " 건이 등록됨.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. 연결해제
			ConnectionManager.close(conn);
		}

		return r;
	}
	
	public int getCount(String id, String name) {
		String strWhere = " where 1 = 1"; //1 과 1이 같아야한다.
		if (id != null && !id.isEmpty()) {
			strWhere += " and id = ?";
		}
		if (name != null && !name.isEmpty()) {
			strWhere += " and name like '%' || ? || '%'";
		}
		int cnt = 0;

		Connection conn = ConnectionManager.getConnnect();
		try {
			String sql = "select count(*) AS cnt from member" + strWhere ;
			PreparedStatement psmt = conn.prepareStatement(sql);
			int position = 1;
			if (id != null && !id.isEmpty()) {
				psmt.setString(position++, id);
			}
			if (name != null && !name.isEmpty()) {
				psmt.setString(position++, name);
			}
			ResultSet rs;
			rs = psmt.executeQuery();
			if (rs.next()) {
				cnt = rs.getInt("cnt");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.close(conn);
		}
		return cnt;
	}

}// end of class
