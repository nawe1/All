package org.gasan.ctrl.data;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gasan.dao.DataDAO;
import org.gasan.dto.Data;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/DataIns.do")
public class DataInsCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DataInsCtrl() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Data data = new Data();
		
		ServletContext application = request.getServletContext(); //pro01
		
		try {
			String saveDirectory = application.getRealPath("/upload"); //pro01/upload
			int maxSize = 1024*1024*10;
			String encoding = "UTF-8";
			//MultipartRequest(요청객체명, 저장디렉토리, 최대크기, 인코딩방식, 폴리시);
			MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxSize, encoding, new DefaultFileRenamePolicy());
			
			data.setTitle(mr.getParameter("title"));
			data.setContent(mr.getParameter("content"));
			//data.setDatafile(mr.getParameter("datafile"));
			
			Enumeration files = mr.getFileNames();
			String item = (String) files.nextElement(); 			
			
			/*
			String[] item = {"","",""};
			String[] oriFile = {"","",""};
			String[] fileName = {"","",""};
			File[] upfile;
			for(int i=1;i<2;i++) {
				item[i] = (String) files.nextElement();
				oriFile[i] = mr.getOriginalFileName(item[i]);
				fileName[i] = mr.getFilesystemName(item[i]);
				upfile[i] = mr.getFile(item[i]);
			}
			data.setDatafile1(upfile[0].getName());
			data.setDatafile2(upfile[1].getName());
			data.setDatafile3(upfile[2].getName());
			*/
			
			String oriFile = mr.getOriginalFileName(item); //d:\kim\pro01\data\data001.zip
			String fileName = mr.getFilesystemName(item); //data001.zip

			File upfile = mr.getFile(item);	//실제 파일 업로드 
			//data.setDatafile(upfile.getName());	//파일이름만 가져와서 datafile 필드에 값 대입
			data.setDatafile(fileName);
			DataDAO dao = new DataDAO();
			int cnt = dao.insData(data);
			
			if(cnt>0) {
				System.out.println("자료 추가 성공~!");
			} else {
				System.out.println("자료 추가 실패~!");
			}

			String home = application.getContextPath();
			if(cnt>0) {
				response.sendRedirect(home+"/DataList.do");
			} else {
				response.sendRedirect(home+"/data/data_ins.jsp");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
