package com.geeksjava.solr.helper;



import com.geeksjava.solr.bean.SolrDocument;
import com.geeksjava.solr.util.SolrUtil;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SolrSearchHelper {
    private String core=null;

    public String addSolrDocument(SolrDocument documentDetail, String core)  {
        try {
            SolrClient solrClient = SolrUtil.getSolrClient();
            final SolrInputDocument doc = new SolrInputDocument();
            doc.addField("id", documentDetail.getId());
            doc.addField("name", documentDetail.getName());
            doc.addField("title", documentDetail.getTitle());
            doc.addField("description", documentDetail.getDescription());
            final UpdateResponse updateResponse = solrClient.add(core, doc);
            solrClient.commit(core);
            return "Document has been added";
        }catch (Exception e){
           System.out.println(e.getMessage());
        }
        return "Document could not be added.";
    }

    public void deleteIndex(String core) {
        try {
            final SolrClient solrClient = SolrUtil.getSolrClient();
            solrClient.deleteByQuery(core, "*");
            final UpdateResponse updateResponse=solrClient.commit(core);
        }catch (SolrServerException | IOException e){
            //LOG.error("\n ERROR While Indexing -  {} ",e.getMessage());
        }
    }

    public void getSearchResult(String core){
        List<Map<String,String>> searchResult = new ArrayList<>();
        try {
            final SolrClient solrClient = SolrUtil.getSolrClient();
            final SolrQuery query = new SolrQuery("*:*");
            final QueryResponse response = solrClient.query(core, query);
            final SolrDocumentList documents = response.getResults();
            for (org.apache.solr.common.SolrDocument document : documents) {
                System.out.println(document.getFirstValue("id")+" : "+document.getFirstValue("name") +" : "+document.getFirstValue("title")+" : "+document.getFirstValue("description"));
            }
        }catch (Exception e){
            //LOG.error("\n Error while search - {} ",e.getMessage());
        }
    }

    public void getSearchText(String core,String text){
        List<Map<String,String>> searchResult = new ArrayList<>();
        try {
            final SolrClient solrClient = SolrUtil.getSolrClient();
            final SolrQuery query = new SolrQuery(text);
            final QueryResponse response = solrClient.query(core, query);
            final SolrDocumentList documents = response.getResults();
            for (org.apache.solr.common.SolrDocument document : documents) {
                System.out.println(document.getFirstValue("id")+" : "+document.getFirstValue("name") +" : "+document.getFirstValue("title")+" : "+document.getFirstValue("description"));
            }
        }catch (Exception e){
            //LOG.error("\n Error while search - {} ",e.getMessage());
        }
    }

}
