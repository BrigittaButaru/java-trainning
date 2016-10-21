package tema4.VotingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.edocti.jintro.lab03.Circle;
import com.edocti.jintro.lab03.EqualityTest;
import com.edocti.jintro.lab03.Shape;
import com.edocti.jintro.lab03.Square;


abstract class  VotableEntity{	
	String name;
	int voteCount;
	
	public VotableEntity(String initname){
		voteCount = 0;
		name = initname;
	}
	public final void Vote(){
		voteCount = voteCount+1;
	}
	public final int GetVoteCount(){
		return voteCount;
	}
	public final String GetName(){
		return name;
	}	
	
	@Override
	public String toString() {
		return name + ": " + voteCount;
	}
}

class Party extends VotableEntity{
	
	String orientation;
	public Party(String partyName, String orientation){
		super(partyName);
		this.orientation=orientation;
	}
	public String toString() {
		return super.toString() + " " + orientation;
	}
}

class VotingSection {
	int votingSectionNumber;
	String city;	
    Map<Person, Boolean> listapersoane; 
    
    public VotingSection(){
    	votingSectionNumber = 0;
    	city = "";
    	listapersoane = new HashMap<Person, Boolean>();
    }
    
    public VotingSection(int initvotingSectionNumber, String initcity, List<Person> initlistapersoane){
    	this.votingSectionNumber=initvotingSectionNumber;
    	this.city=initcity;
  
    	listapersoane = new HashMap<Person, Boolean>();
    	for(Person p:initlistapersoane){
    		listapersoane.put(new Person(p.name, p.CNP), false);
    	}
    }
    
    public void vote(Person person,VotableEntity vs){
    	
    	for (Map.Entry<Person, Boolean> entry : listapersoane.entrySet()) {
    	    Person p = entry.getKey();
    	    Boolean b = entry.getValue();
    	    
    	    if( person.equals(p) && false==b){
    	    	vs.Vote();
    	    	break;
    	    }
    	}    	
    }
}

class Person {
	String name;
	String  CNP;
	
	public Person(String initname,String initCNP ){
		this.name = initname;
		this.CNP = initCNP;
	}
	
	public String toString() {
		return name + " - CNP: " + CNP;
	}
	public boolean equals(Person p){
		if( this.name.equals(p.name) && (this.CNP == p.CNP))
			return true;
		return false;
	}	
}


public class VotingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<VotableEntity> listapartide=new ArrayList<VotableEntity>();
		listapartide.add(new Party("PSD","Stanga"));
		listapartide.add(new Party("USR","Dreapta"));		
		
		List<Person> listapersoane1=new ArrayList<Person>();
		listapersoane1.add(new Person("Maria","234534657643"));
		listapersoane1.add(new Person("Ion","124523654756"));
		
		List<Person> listapersoane2=new ArrayList<Person>();
		listapersoane2.add(new Person("Antonia","234534657643"));
		listapersoane2.add(new Person("Dorel","124523654756"));
		
		List<Person> listapersoane3=new ArrayList<Person>();
		listapersoane3.add(new Person("Mara","234534657643"));
		listapersoane3.add(new Person("Luci","124523654756"));
		listapersoane3.add(new Person("Roxi","124523654756"));
	    
		List<VotingSection> listasectiivotare=new ArrayList<VotingSection>();
		listasectiivotare.add(new VotingSection(1,"Oradea",listapersoane1));
		listasectiivotare.add(new VotingSection(2,"Oradea",listapersoane2));
		listasectiivotare.add(new VotingSection(3,"Oradea",listapersoane3));

		List<Person> listapersoane =new ArrayList<Person>();
		listapersoane.addAll(listapersoane1);
		listapersoane.addAll(listapersoane2);
		listapersoane.addAll(listapersoane3);
		
		for(int i=0;i<10;i++){
			
			int pickperson = new Random().nextInt(listapersoane.size());
			Person person = listapersoane.get(pickperson);
			
			int pickparty =  new Random().nextInt(listapartide.size());
			VotableEntity party = listapartide.get(pickparty);
			
			System.out.println("Person :"+ person + "voted " + party);
			for(VotingSection vs: listasectiivotare){
				vs.vote(person, party); 				
			}	
		}
		
		
		Iterator it = listapartide.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}		
	}
}

