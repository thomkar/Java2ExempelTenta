
import java.util.*;

public class Book {
	
	private String title;
	private String author;
	private ArrayList<Chapter> chapters = new ArrayList<>();
	
	
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void addChapter(Chapter chapter) {
		chapters.add(chapter);
	}
	
	public boolean removeChapter(int chapterNumber) {
		boolean removed = false;
		for (Chapter c : chapters) {
			if ( c.getChapterNumber() == chapterNumber) {
				chapters.remove(chapters.indexOf(c));
				removed = true;
			}
		}
		return removed;
	}
	
	public ArrayList<Chapter> getAllChapters() {
		return chapters;
	}
	
	public Chapter getChapter(int chapterNumber) throws ChapterMissingException {
		for (Chapter c : chapters) {
			if ( c.getChapterNumber() == chapterNumber) {
				return c;
			}
		}
			throw new ChapterMissingException("No chapter number " + chapterNumber + " exists.");
	}
	
	public void sortByChapterNumber() {		
		chapters.sort((c1, c2) -> Integer.compare(c1.getChapterNumber(), c2.getChapterNumber()));
	}

	public void sortByTextLength() {
		chapters.sort((c1, c2) -> Integer.compare(c2.getTextLength(), c1.getTextLength()));
	}
	
	public void sortByChapterHeading() {
		chapters.sort((c1, c2) -> c1.getChapterHeading().compareTo(c2.getChapterHeading()));
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", Number of chapters=" + chapters.size() + "]";
	}
	
	public ArrayList<Chapter> search(String searchString) {
		ArrayList<Chapter> results = new ArrayList<>();
		for (Chapter c : chapters ) {
			if (c.getText().contains(searchString))
				results.add(c);
		}
		return results;
	 
	}
	
	public static Book createTestBook() {
		
		Book testBook = new Book("Pro Git", "Joakim von Anka");
		Chapter c1 = new Chapter( 1, "Gettin Started");
		Chapter c2 = new Chapter( 6, "GitHub");
		Chapter c3 = new Chapter( 2, "Git Basics");
		Chapter c4 = new Chapter( 11, "Git Tools");
		Chapter c5 = new Chapter( 9, "Distributed Git");

		c1.setText("This chapter will be about getting started with Git. We will begin by explaining some background " +
				"on version control tools, then move on to how to get Git running on your system and finally how to " +
				"get it set up to start working with. At the end of this chapter you should understand why Git is " +
				"around, why you should use it and you should be all set up to do so.");
				
		c3.setText("If you can read only one chapter to get going with Git, this is it. This chapter covers every basic " +
		        "command you need to do the vast majority of the things you’ll eventually spend your time doing " +
				"with Git. By the end of the chapter, you should be able to configure and initialize a repository, begin " +
				"and stop tracking files, and stage and commit changes. We’ll also show you how to set up Git to " +
				"ignore certain files and file patterns, how to undo mistakes quickly and easily, how to browse the " +
				"history of your project and view changes between commits, and how to push and pull from remote " +
				"repositories.");
								
		c5.setText("Now that you have a remote Git repository set up as a focal point for all the developers to share " +
				"their code, and you’re familiar with basic Git commands in a local workflow, you’ll look at how to " +
				"utilize some of the distributed workflows that Git affords you. " +
				"In this chapter, you’ll see how to work with Git in a distributed environment as a contributor and " +
				"an integrator. That is, you’ll learn how to contribute code successfully to a project and make it as " +
				"easy on you and the project maintainer as possible, and also how to maintain a project successfully " +
				"with a number of developers contributing.");
								
		c2.setText("GitHub is the single largest host for Git repositories, and is the central point of collaboration for " +
				"millions of developers and projects. A large percentage of all Git repositories are hosted on GitHub, " +
				"and many open-source projects use it for Git hosting, issue tracking, code review, and other things. " +
				"So while it’s not a direct part of the Git open source project, there’s a good chance that you’ll want " +
				"or need to interact with GitHub at some point while using Git professionally. " +
				"This chapter is about using GitHub effectively. We’ll cover signing up for and managing an account, " +
				"creating and using Git repositories, common workflows to contribute to projects and to accept " +
				"contributions to yours, GitHub’s programmatic interface and lots of little tips to make your life " +
				"easier in general. " +
				"If you are not interested in using GitHub to host your own projects or to collaborate with other " +
				" that are hosted on GitHub, you can safely skip to Git Tools.");
								
		c4.setText("By now, you’ve learned most of the day-to-day commands and workflows that you need to manage  " +
				"or maintain a Git repository for your source code control. You’ve accomplished the basic tasks of " +
				"tracking and committing files, and you’ve harnessed the power of the staging area and lightweight " +
				"topic branching and merging. " +
				"Now you’ll explore a number of very powerful things that Git can do that you may not necessarily " +
				"use on a day-to-day basis but that you may need at some point.");
		
		testBook.addChapter(c1);
		testBook.addChapter(c3);
		testBook.addChapter(c5);
		testBook.addChapter(c2);
		testBook.addChapter(c4);				
				
		return testBook;
	}
	
}
