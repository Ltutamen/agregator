package ua.axiom.aggregator.connectivity.model;

public class TokenHttpResponse {
        private String access_token;
        private String token_type;
        private String expires_in;
        private String scope;
        private String refresh_token;

    public TokenHttpResponse(String access_token, String token_type, String expires_in, String scope, String refresh_token) {
        this.access_token = access_token;
        this.token_type = token_type;
        this.expires_in = expires_in;
        this.scope = scope;
        this.refresh_token = refresh_token;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}
