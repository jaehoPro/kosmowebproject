package vocabularyList.vo;

public class CheckableItemVO {
	private String  str;
	private boolean isSelected;

	public CheckableItemVO(String str) {
		this.str = str;
		isSelected = false;
	}

	public void setSelected(boolean b) {
		isSelected = b;   
	}

	public boolean isSelected() {
		return isSelected;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	
}
