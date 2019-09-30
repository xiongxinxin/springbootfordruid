package com.xxx.springbootfordruid.service.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

import com.xxx.springbootfordruid.service.MultiThreadService;

@Service
public class MultiThreadServiceImpl implements MultiThreadService{
	
	public void dealFile(String filePath) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
			String lineString = "";
			while((lineString = br.readLine())!=null){
				System.out.println(lineString);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
