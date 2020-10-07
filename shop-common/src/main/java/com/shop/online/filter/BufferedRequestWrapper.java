package com.shop.online.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class BufferedRequestWrapper extends HttpServletRequestWrapper {
	
	private byte[] buffer = null;

	public BufferedRequestWrapper(HttpServletRequest request) throws IOException {
		super(request);
		InputStream is = request.getInputStream();
		try(ByteArrayOutputStream bos = new ByteArrayOutputStream();){
			byte[] buf = new byte[1024];
			int len = 0;
			while((len = is.read(buf)) > 0) {
				bos.write(buf, 0, len);
			}
			this.buffer = bos.toByteArray();
		}
	}
	
	
	@Override
	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream bais = new ByteArrayInputStream(buffer);

        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return bais.read();
            }

			@Override
			public boolean isFinished() {
				return bais.available() == 0;
			}

			@Override
			public boolean isReady() {
				return true;
			}

			@Override
			public void setReadListener(ReadListener arg0) {
				
			}
        };
	}

	public String getRequestBody() throws IOException {
		return new String(this.buffer, "UTF-8");
	}
	
	

}