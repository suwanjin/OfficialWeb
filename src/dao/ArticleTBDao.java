package dao;

import java.util.List;

import entity.ArticleTB;
import entity.ArticleTypeTB;

/**
 * 文章接口
 * @author Administrator
 *
 */
public interface ArticleTBDao {
	 int addArticleTB(String path,ArticleTB articleTB);//添加文章
	 int deleteArticleTB(String aId,String path);//根据文章ID删除文章
	 int updateArticleTB(ArticleTB articleTB,String path);//根据文章ID修改文章
	//根据文章类型ID查询文章后，以文章创建时间降序排列
	 List<ArticleTB> searchArticleTB(String aArticleTypetbID,String aArticleTitle,String start,String end);
	 ArticleTB searchArticleTBByID(String aId,String path);//根据文章ID查询文章
	 ArticleTypeTB searchArticleTypeTBByArticleTBId(String aID);//根据文章id查询文章类型
	 String getTitleById(String id);//根据文章id返回文章标题
}
