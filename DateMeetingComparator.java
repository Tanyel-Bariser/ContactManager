import java.util.Comparator;

public class DateMeetingComparator implements Comparator<Meeting>{
	public int compare(Meeting meetingOne, Meeting meetingTwo) {
		return meetingOne.getDate().compareTo(meetingTwo.getDate());
	}

}