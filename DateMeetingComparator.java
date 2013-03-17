import java.util.Comparator;
/**
* A class which facilitates the ability to sort meetings by date
*/
public class DateMeetingComparator implements Comparator<Meeting>{
    /**
    * Sorts meetings dates in chronological order
    *
    * @param meetingOne first meeting to compare to second meeting
    * @param meetingTwo second meeting to compare to first meeting
    */
    public int compare(Meeting meetingOne, Meeting meetingTwo) {
        return meetingOne.getDate().compareTo(meetingTwo.getDate());
    }
}