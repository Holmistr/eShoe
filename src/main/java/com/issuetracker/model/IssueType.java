package com.issuetracker.model;

import com.github.holmistr.esannotations.indexing.annotations.Analyzer;
import com.github.holmistr.esannotations.indexing.annotations.Field;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author mgottval
 */
@Entity
public class IssueType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Field
    @Analyzer(name = "issueTypeNameAnalyzer", tokenizer = "keyword", tokenFilters = "lowercase")
    @Column(unique = true)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof IssueType)) {
            return false;
        }
        IssueType other = (IssueType) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.issuetracker.IssueType[ id=" + id + " ]";
    }
    
}
