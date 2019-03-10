package com.perscholas.springmvc_sba.models;

	public class Poem {
	public int ID;
	public String title;
	public String author;
	public String poemText;

	public Poem(String title, String author, String poemText) {
		this.title = title;
		this.author = author;
		this.poemText = poemText;
	}
	
	public Poem(int ID, String title, String author, String poemText) {
		this.ID = ID;
		this.title = title;
		this.author = author;
		this.poemText = poemText;
	}
	
	public Poem(String poemText) {
		this.poemText = poemText;
	}
	
	public Poem(){
		
	}
	
	public Poem(int ID) {
		this.ID = ID;
	}
	
    public Integer getID()
    {
        return ID;
    }

    public void setID(Integer ID)
    {
        this.ID= ID;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public String getAuthor()
    {
        return author;
    }
    
    public void setAuthor(String author)
    {
        this.author = author;
    }
    public String getPoemText()
    {
        return poemText;
    }
    
    public void setPoemText(String poemText)
    {
        this.poemText = poemText;
    }
}
