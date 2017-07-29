package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import dao.impl.ArticleTBDaoImpl;
import dao.impl.ArticleTypeTBDaoImpl;

import entity.AdminTB;
import entity.ArticleTB;
import entity.ArticleTypeTB;

public class IDServlet extends HttpServlet {
	

	/**
	 * ��ȡID��servlet
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			String method=request.getParameter("method");
			String id=(String)request.getAttribute("id");
			String start=request.getParameter("start");
			String end=request.getParameter("end");
			
			//������������ID��ѯ���º������´���ʱ�併������
			PrintWriter out=response.getWriter();
			 if(method.equalsIgnoreCase("searchArticleTB")){
				 List<ArticleTB> list=new ArticleTBDaoImpl().searchArticleTB(id, start, end);
				 JSONArray ja=new JSONArray().fromObject(list);
				 out.write(ja.toString());
				 return;
			}//��������ID��ѯ����
			else if(method.equalsIgnoreCase("searchArticleTBByID")){
				ArticleTB at=new  ArticleTBDaoImpl().searchArticleTBByID(id);
				JSONObject json=new JSONObject().fromObject(at);
				out.write(json.toString());
				return;
			}
			 //���ݵ���ID��ѯ�������ͼ���
			else if(method.equalsIgnoreCase("searchArticleTypeTB")){
				 List<ArticleTypeTB> list=new ArticleTypeTBDaoImpl().searchArticleTypeTB(id);
				 JSONArray ja=new JSONArray().fromObject(list);
				 out.write(ja.toString());
				 return;
			}
			 //��ȡ����Ա��Ϣ
			else{
				AdminTB admin=(AdminTB)request.getSession().getAttribute("admin");
				JSONObject json=new JSONObject().fromObject(admin);
				out.write(json.toString());
				return;
			}
	}
}