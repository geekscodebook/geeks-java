package com.geeksjava.solr;

import com.geeksjava.solr.bean.SolrDocument;
import com.geeksjava.solr.helper.SolrSearchHelper;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        SolrDocument solrDocument1=new SolrDocument("doc1","page1","Page 1","This is Page 1");
        SolrDocument solrDocument2=new SolrDocument("doc2","page2","Page 2","This is Page 2");
        SolrDocument solrDocument3=new SolrDocument("doc3","page3","Page 3","This is Page 3");
        SolrDocument solrDocument4=new SolrDocument("doc4","page4","Page 4","This is Page 4");

        SolrSearchHelper solrSearchHelper=new SolrSearchHelper();
        /*solrSearchHelper.addSolrDocument(solrDocument1,"geekscodebook");
        solrSearchHelper.addSolrDocument(solrDocument2,"geekscodebook");
        solrSearchHelper.addSolrDocument(solrDocument3,"geekscodebook");
        solrSearchHelper.addSolrDocument(solrDocument4,"geekscodebook");*/

       // solrSearchHelper.deleteIndex("geekscodebook");
        //  solrSearchHelper.getSearchResult("geekscodebook");
        solrSearchHelper.getSearchText("geekscodebook","page1");

        //System.out.println( "Hello World!" );
    }
}
