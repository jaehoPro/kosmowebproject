package vocabularyList.vo;

public class TucVO {
	private PhraseVO phrase; 
	private String meaningId; 
	private String[] authors;
	
	
	public PhraseVO getPhrase() {
		return phrase;
	}
	public void setPhrase(PhraseVO phrase) {
		this.phrase = phrase;
	}
	public String getMeaningId() {
		return meaningId;
	}
	public void setMeaningId(String meaningId) {
		this.meaningId = meaningId;
	}
	public String[] getAuthors() {
		return authors;
	}
	public void setAuthors(String[] authors) {
		this.authors = authors;
	}
	
	
}
