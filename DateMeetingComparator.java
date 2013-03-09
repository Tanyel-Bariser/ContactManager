import java.util.Comparator;
//A class which facilitates the ability to sort meetings by date
public class DateMeetingComparator implements Comparator<Meeting>{
	public int compare(Meeting meetingOne, Meeting meetingTwo) {
		return meetingOne.getDate().compareTo(meetingTwo.getDate());
	}

}