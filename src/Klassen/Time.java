package Klassen;

public class Time {
    private int hours;   // 0-23
    private int minutes; // 0-59
    private int seconds; // 0-59


    public Time() {
        this(0, 0, 0);
    }

    public Time(int hours) {
        this(hours, 0, 0);
    }

    public Time(int hours, int minutes) {
        this(hours, minutes, 0);
    }

    public Time(int hours, int minutes, int seconds) {
        setTime(hours, minutes, seconds);
    }


    private void setTime(int h, int m, int s) {
        if (h < 0 || h > 23) h = 0;
        if (m < 0 || m > 59) m = 0;
        if (s < 0 || s > 59) s = 0;

        this.hours = h;
        this.minutes = m;
        this.seconds = s;
    }


    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }


    public Time clone() {
        return new Time(this.hours, this.minutes, this.seconds);
    }


    public boolean isEqualTo(Time other) {
        return this.hours == other.hours &&
                this.minutes == other.minutes &&
                this.seconds == other.seconds;
    }


    public void add(Time other) {
        this.seconds += other.seconds;
        this.minutes += other.minutes + this.seconds / 60;
        this.hours += other.hours + this.minutes / 60;

        this.seconds %= 60;
        this.minutes %= 60;
        this.hours %= 24;
    }


    public void tick() {
        this.seconds++;
        if (this.seconds == 60) {
            this.seconds = 0;
            this.minutes++;
            if (this.minutes == 60) {
                this.minutes = 0;
                this.hours = (this.hours + 1) % 24;
            }
        }
    }


    public Time differenceTo(Time other) {
        int thisTotal = this.hours * 3600 + this.minutes * 60 + this.seconds;
        int otherTotal = other.hours * 3600 + other.minutes * 60 + other.seconds;

        int diff = otherTotal - thisTotal;
        if (diff < 0) {
            diff += 24 * 3600; // über Mitternacht
        }

        int h = diff / 3600;
        diff %= 3600;
        int m = diff / 60;
        int s = diff % 60;

        return new Time(h, m, s);
    }


    @Override
    public String toString() {
        return String.format("Time(hours: %d, minutes: %d, seconds: %d)",
                hours, minutes, seconds);
    }
}
