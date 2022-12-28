package spring;

import java.util.Collection;

public class MemberListPrinter {
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter printer) {
		this.memberDao = memberDao;
		this.printer = printer;
	}
	
	public void printAll() {
		Collection<Member> members = memberDao.selectAll();
		
		// 아래 for 문과 똑같다
		// members.forEach(member -> printer.print(member));
		//                 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//                         람다식
		for (Member member : members) {
			printer.print(member);
		}
	}
}
