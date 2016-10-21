package tema3.StateMachine;

import java.util.Random;

public class StateMachine {
	
	enum CustomerSatisfaction { 
		PLEASED, SATISFIED, UNPLEASED, FURIOUS, UNDEFINED;
		public void run() {
			System.out.println("I am " + this.name().toLowerCase());
			}
		}
	
	enum ProjectEvent {
		ISSUE_SOLVED, ELEGANT_SOLUTION, SOLUTION_INTRODUCED_BUGS, NASTY_WORKAROUND;
	}
	
	enum ProjectTransition {
		T1(CustomerSatisfaction.PLEASED, ProjectEvent.ISSUE_SOLVED, CustomerSatisfaction.SATISFIED),
		T2(CustomerSatisfaction.SATISFIED, ProjectEvent.NASTY_WORKAROUND, CustomerSatisfaction.UNPLEASED),
		T3(CustomerSatisfaction.UNPLEASED, ProjectEvent.NASTY_WORKAROUND, CustomerSatisfaction.FURIOUS),
		T4(CustomerSatisfaction.UNPLEASED, ProjectEvent.ELEGANT_SOLUTION, CustomerSatisfaction.PLEASED),
		T5(CustomerSatisfaction.PLEASED, ProjectEvent.SOLUTION_INTRODUCED_BUGS, CustomerSatisfaction.UNPLEASED);
		private CustomerSatisfaction curent, next;
		private ProjectEvent event;
		
		private ProjectTransition(CustomerSatisfaction curent, ProjectEvent event, CustomerSatisfaction next){
			this.curent = curent;
			this.event = event;
			this.next = next;
		} 
		
		public static CustomerSatisfaction next(CustomerSatisfaction curent, ProjectEvent event){
			for( ProjectTransition t : ProjectTransition.values() ){
				if( t.curent == curent && t.event == event )
					return t.next;
			}	
			return CustomerSatisfaction.UNDEFINED;
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	    int pickevent = new Random().nextInt(ProjectEvent.values().length);
	    int pickcustomers = new Random().nextInt(CustomerSatisfaction.values().length);
		
	   ProjectEvent event = ProjectEvent.values()[pickevent];
	   CustomerSatisfaction curent = CustomerSatisfaction.values()[pickcustomers];
	   System.out.println(curent.name());
	   System.out.println(event.name());
	   CustomerSatisfaction nexstate = ProjectTransition.next(curent, event);   
	   System.out.println(nexstate.name());
	}

}
