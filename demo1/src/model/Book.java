package model;

import java.util.Date;

public class Book {
	private Long id;
	private Long bookId;
	private String bookName;
	private String author;
	private Integer price;
	private Date publishDate;
	private String kind;
	private Integer totalStore;
	private Integer totalSold;
	private String pic;
	private String profile;
	private Boolean status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Integer getTotalStore() {
		return totalStore;
	}
	public void setTotalStore(Integer totalStore) {
		this.totalStore = totalStore;
	}
	public Integer getTotalSold() {
		return totalSold;
	}
	public void setTotalSold(Integer totalSold) {
		this.totalSold = totalSold;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", price=" + price
				+ ", publishDate=" + publishDate + ", kind=" + kind + ", totalStore=" + totalStore + ", totalSold="
				+ totalSold + ", pic=" + pic + ", profile=" + profile + ", status=" + status + "]";
	}
}
