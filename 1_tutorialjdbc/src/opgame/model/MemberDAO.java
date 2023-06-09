package opgame.model;

import java.util.Optional;

public class MemberDAO extends BaseDAO {
    public void initMember() {
    }

    public Optional<Member> login(String id, String pw) {
        return Optional.empty();
    }

    public void join(String id, String pw) {

    }

    public Optional<Member> logout(String id) {
        return null;
    }
}

