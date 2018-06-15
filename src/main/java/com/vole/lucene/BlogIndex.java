package com.vole.lucene;

import com.vole.entity.Blog;
import com.vole.util.ConstantUtil;
import com.vole.util.DateUtil;
import com.vole.util.StringUtil;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.StringReader;
import java.nio.file.Paths;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 编写者： vole
 * Time： 2018/6/4.10:21
 * 内容：备忘录索引类
 */
public class BlogIndex {

    private Directory dir = null;

    /**
     * 获取 IndexWriter 实例
     *
     * @return IndexWriter
     * @throws Exception n
     */
    private IndexWriter getWriter() throws Exception {
        dir = FSDirectory.open(Paths.get(ConstantUtil.SAVE_LUCENE_DIR));
        SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig(analyzer);
        return new IndexWriter(dir, config);
    }

    /**
     * 添加博客索引
     *
     * @param blog Blog
     */
    public void addIndex(Blog blog) throws Exception {
        IndexWriter writer = getWriter();
        Document doc = new Document();
        doc.add(new StringField("id", String.valueOf(blog.getId()), Field.Store.YES));
        doc.add(new TextField("title", blog.getTitle(), Field.Store.YES));
        doc.add(new StringField("releaseDate", DateUtil.formatDate(new Date(), "yyyy-MM-dd"), Field.Store.YES));
        doc.add(new TextField("content", blog.getContent(), Field.Store.YES));
        writer.addDocument(doc);
        writer.close();
    }


    /**
     * 更新博客索引
     *
     * @param blog Blog
     * @throws Exception e
     */
    public void updateIndex(Blog blog) throws Exception {
        IndexWriter writer = getWriter();
        Document doc = new Document();
        doc.add(new StringField("id", String.valueOf(blog.getId()), Field.Store.YES));
        doc.add(new TextField("title", blog.getTitle(), Field.Store.YES));
        doc.add(new StringField("releaseDate", DateUtil.formatDate(new Date(), "yyyy-MM-dd"), Field.Store.YES));
        doc.add(new TextField("content", blog.getContent(), Field.Store.YES));
        writer.updateDocument(new Term("id", String.valueOf(blog.getId())), doc);
        writer.close();
    }

    /**
     * 删除指定博客的索引
     *
     * @param blogId id
     * @throws Exception e
     */
    public void deleteIndex(String blogId) throws Exception {
        IndexWriter writer = getWriter();
        writer.deleteDocuments(new Term("id", blogId)); // 强制删除
        writer.forceMergeDeletes();
        writer.commit();
        writer.close();
    }


    /**
     * 查询博客信息
     *
     * @param q 查询关键字
     * @return 备忘录集合
     * @throws Exception e
     */
    public List<Blog> searchBlog(String q) throws Exception {
        dir = FSDirectory.open(Paths.get(ConstantUtil.SAVE_LUCENE_DIR));
        System.err.println(dir);
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher is = new IndexSearcher(reader);
        BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
        SmartChineseAnalyzer analyzer = new SmartChineseAnalyzer();
        QueryParser parser = new QueryParser("title", analyzer);
        Query query = parser.parse(q);
        QueryParser parser2 = new QueryParser("content", analyzer);
        Query query2 = parser2.parse(q);
        booleanQuery.add(query, BooleanClause.Occur.SHOULD);
        booleanQuery.add(query2, BooleanClause.Occur.SHOULD);
        TopDocs hits = is.search(booleanQuery.build(), 100);
        QueryScorer scorer = new QueryScorer(query);
        Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
        SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color='red'>", "</font></b>");
        Highlighter highlighter = new Highlighter(simpleHTMLFormatter, scorer);
        highlighter.setTextFragmenter(fragmenter);
        List<Blog> blogList = new LinkedList<>();
        for (ScoreDoc scoreDoc : hits.scoreDocs) {
            Document doc = is.doc(scoreDoc.doc);
            Blog blog = new Blog();
            blog.setId(Integer.parseInt(doc.get(("id"))));
            blog.setReleaseDateStr(doc.get(("releaseDate")));
            String title = doc.get("title");
            //添加标签过滤转义
            String content = StringEscapeUtils.escapeHtml(doc.get("content"));
            if (title != null) {
                TokenStream tokenStream = analyzer.tokenStream("title", new StringReader(title));
                String hTitle = highlighter.getBestFragment(tokenStream, title);
                if (StringUtil.isEmpty(hTitle)) {
                    blog.setTitle(title);
                } else {
                    blog.setTitle(hTitle);
                }
            }
            if (content != null) {
                TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(content));
                String hContent = highlighter.getBestFragment(tokenStream, content);
                if (StringUtil.isEmpty(hContent)) {
                    if (content.length() <= 200) {
                        blog.setContent(content);
                    } else {
                        blog.setContent(content.substring(0, 200));
                    }
                } else {
                    blog.setContent(hContent);
                }
            }
            blogList.add(blog);
        }
        return blogList;
    }

}
