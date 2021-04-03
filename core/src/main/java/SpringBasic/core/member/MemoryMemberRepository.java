package SpringBasic.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {
    private static final Map<Long, Member> store = new HashMap<>();
    /*ConCurrent Hashmap을 써야함 -> 동시성 이유 (여기선 예제라 일단 Hashmap만)
    * Concurrent Hashmap에 대해서는 따로 알아보도록 하자! (동시성 이슈)*/

    @Override
    public void save(Member member)
    {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

}
