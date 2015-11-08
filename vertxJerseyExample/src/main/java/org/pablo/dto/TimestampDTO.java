package org.pablo.dto;


public class TimestampDTO {

    private String timeInISO8601;

    private long timeInMillisFrom1970;

    public String getTimeInISO8601() {
	return timeInISO8601;
    }

    public void setTimeInISO8601(String timeInISO8601) {
	this.timeInISO8601 = timeInISO8601;
    }

    public long getTimeInMillisFrom1970() {
	return timeInMillisFrom1970;
    }

    public void setTimeInMillisFrom1970(long timeInMillisFrom1970) {
	this.timeInMillisFrom1970 = timeInMillisFrom1970;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (timeInMillisFrom1970 ^ (timeInMillisFrom1970 >>> 32));
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	TimestampDTO other = (TimestampDTO) obj;
	if (timeInMillisFrom1970 != other.timeInMillisFrom1970)
	    return false;
	return true;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "TimestampDTO [timeInISO8601=" + timeInISO8601 + ", timeInMillisFrom1970=" + timeInMillisFrom1970 + "]";
    }

}
