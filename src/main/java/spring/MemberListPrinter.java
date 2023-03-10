package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberListPrinter {
	
	
	private MemberDao memberDao;
	private MemberPrinter printer;
	
	
	public MemberListPrinter() {
		
	}	
	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}	
	@Autowired
	@Qualifier("summaryPrinter")  
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}

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
