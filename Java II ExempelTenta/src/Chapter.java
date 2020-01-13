
public class Chapter {
	
	private int chapterNumber;
	private String chapterHeading;
	private String text;

	
	public Chapter(int chapterNumber, String chapterHeading, String text) {
		super();
		this.chapterNumber = chapterNumber;
		this.chapterHeading = chapterHeading;
		this.text = text;
	}


	public Chapter(int chapterNumber, String chapterHeading) {
		super();
		this.chapterNumber = chapterNumber;
		this.chapterHeading = chapterHeading;
	}


	public int getChapterNumber() {
		return chapterNumber;
	}


	public void setChapterNumber(int chapterNumber) {
		this.chapterNumber = chapterNumber;
	}


	public String getChapterHeading() {
		return chapterHeading;
	}


	public void setChapterHeading(String chapterHeading) {
		this.chapterHeading = chapterHeading;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}
	
	public int getTextLength() {
		return text.length();
	}


	@Override
	public String toString() {
		return "Chapter [chapterNumber=" + chapterNumber + ", chapterHeading=" + chapterHeading + "]";
	}



}
