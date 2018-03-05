/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studio.portfolio.ui;

import com.studio.portfolio.entities.Recruters;
import com.studio.portfolio.util.MessagesUtil;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author null
 */
@Named("recruters")
@SessionScoped
public class RecrutersUI implements Serializable {

    private final String GITLAB = "https://www.gitlab.com/Danielifg";
    private final String GITHUB = "https://www.github.com/Danielifg";
    private final String LINKEDIN = "https://www.linkedin.com/in/Danielifg";
    private final String CODEPEN = "https://codepen.io/danielifguerrero";
    private final String AC_NEWS = "https://www.businesswire.com/news/home/20140926005028/en/NeXovation-Launches-Impactivate-Networks-Atlantic-City";

    @Inject
    private Recruters recruter;

    public Recruters getRecruter() {
        return recruter;
    }

    public void setRecruter(Recruters recruter) {
        this.recruter = recruter;
    }

    public String getAccess() {
        String access = " ";
        if (recruter.getCompany() == null || recruter.getName() == null) {
            String signIn = "";
            FacesMessage message = MessagesUtil.
                    getMessage("bundles.ValidationMessages", "accessDenied", new Object[]{signIn});
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            access = "resume";
        }
        return access;
    }

    public void getGITLAB() throws IOException {
        HttpServletResponse response
                = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.sendRedirect(GITLAB);        
    }

    public void getGITHUB() throws IOException {
         HttpServletResponse response
                = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.sendRedirect(GITHUB);        
    }

    public void getLINKEDIN() throws IOException {
         HttpServletResponse response
                = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.sendRedirect(LINKEDIN);        
    }

    public void getCODEPEN() throws IOException {
         HttpServletResponse response
                = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.sendRedirect(CODEPEN);        
    }

    public void getAC_NEWS() throws IOException{
         HttpServletResponse response
                = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.sendRedirect(AC_NEWS);
    }
}
