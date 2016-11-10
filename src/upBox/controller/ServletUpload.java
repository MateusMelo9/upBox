package upBox.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import sun.net.util.IPAddressUtil;
import upBox.DAO.FileDAO;
import upBox.connection.ConnectionFactory;
import upBox.model.FileEntity;

/**
 * Servlet implementation class ServletUpload
 */
@WebServlet("/ServletUpload")
public class ServletUpload extends HttpServlet {
	private static final long serialVersionUID = 182349L;

	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 1000 * 1024;
	private int maxMemSize = 1000 * 1024;
	private File file;

	@Override
	public void init() throws ServletException {
		// pegar a localiza��o onde o arquivo seria armazenado
		filePath = getServletContext().getInitParameter("file-upload");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		throw new ServletException("GET method used with " + getClass().getName() + ": POST method required.");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// verificar se tem um pedido de upload
		isMultipart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if (!isMultipart) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<p>No file uploaded</p>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// tamanho maximo que sera armazenado na memoria
		factory.setSizeThreshold(maxMemSize);
		// localiza��o para guardar os dados do tamanho de maxMemSize
		factory.setRepository(new File("c:/upload/"));
		// criar um novo manipulador de arquivo
		ServletFileUpload upload = new ServletFileUpload(factory);

		upload.setSizeMax(maxFileSize);

		// obter itens dos arquivos
		try {
			List fileItens = upload.parseRequest(request);
			// processar os itens do arquivo
			Iterator i = fileItens.iterator();
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			
			String fieldName=null;
			String fileName=null;
			String contentType;
			boolean isInMemory;
			long sizeBytes;
			
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {
					// pegar os parametros do arquivo
					fieldName = fi.getFieldName();
					fileName = fi.getName();
					contentType = fi.getContentType();
					isInMemory = fi.isInMemory();
					sizeBytes = fi.getSize();
					// escreve o arquivo
					if (fileName.lastIndexOf("\\") >= 0) {
						file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\")));
					} else {
						file = new File(filePath + fileName.substring(fileName.lastIndexOf("\\") + 1));
					}
					fi.write(file);
					out.println("Uploaded Filename: " + fileName + "<br>");
					System.out.println(fieldName+","+fileName+","+filePath);
				}
			}
			out.println("</body>");
			out.println("</html>");
			
			String path = filePath+fileName;
			FileEntity file = new FileEntity();
			file.setNome(fileName);
			file.setCaminho(path);
			
			FileDAO dao = new FileDAO();
			dao.adicionar(file);
			
			//getServletContext().getRequestDispatcher("/upload.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
