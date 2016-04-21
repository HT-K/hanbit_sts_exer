package com.hanbit.web.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	private FileOutputStream fos;
	// 이미지나 동영상을 처리해주는 것이 MultipartFile 이다
	public String uploadFile(MultipartFile file, String path, String fileName) {
		// 이미지는 픽셀 단위로 끊어져서 byte를 사용한다?!
		try {
			byte[] fileData = file.getBytes();
			// \ 하나는 이스케이프를 뜻하고 \\가 ("\")를 의미한다 ("\n", "\t" 를 생각하면 이해하기 쉽다)
			fos = new FileOutputStream(path + "\\" + fileName);
			fos.write(fileData);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return path+fileName;
	}
}
