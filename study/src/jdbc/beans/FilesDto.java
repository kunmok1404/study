package jdbc.beans;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilesDto {
	private String saveName;
	private String uploadName;
	private String type;
	private long len;
	
	public FilesDto(ResultSet rs ) throws SQLException{
		setSaveName(rs.getString("savename"));
		setUploadName(rs.getString("uploadname"));
		setLen(rs.getLong("len"));
		setType(rs.getString("type"));
	}
	
	public FilesDto() {
		
	}
	
	public String getSaveName() {
		return saveName;
	}
	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}
	
	public String getSendName() throws UnsupportedEncodingException {
		return URLEncoder.encode(uploadName, "UTF-8");
	}

	public String getUploadName() {
		return uploadName;
	}
	public void setUploadName(String uploadName) {
		this.uploadName = uploadName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public long getLen() {
		return len;
	}
	public void setLen(long len) {
		this.len = len;
	}
}
