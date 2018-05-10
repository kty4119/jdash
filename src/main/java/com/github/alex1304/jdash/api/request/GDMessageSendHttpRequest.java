package com.github.alex1304.jdash.api.request;

import java.util.Base64;

import com.github.alex1304.jdash.api.GDHttpRequest;
import com.github.alex1304.jdash.api.GDHttpResponseBuilder;
import com.github.alex1304.jdash.component.GDBoolean;
import com.github.alex1304.jdash.util.robtopsweakcrypto.RobTopsWeakCrypto;

/**
 * HTTP request to send a message in Geometry Dash
 * 
 * @author Alex1304
 */
public class GDMessageSendHttpRequest extends GDHttpRequest<GDBoolean> {

	public GDMessageSendHttpRequest(long toAccountID, String subject, String body) {
		super("/uploadGJMessage20.php", true);
		this.getParams().put("toAccountID", "" + toAccountID);
		this.getParams().put("subject", Base64.getUrlEncoder().encodeToString(subject.getBytes()));
		this.getParams().put("body", RobTopsWeakCrypto.encodeGDMessageBody(body));
	}

	@Override
	public GDHttpResponseBuilder<GDBoolean> responseBuilderInstance() {
		return response -> new GDBoolean(response.equals("1"));
	}

}