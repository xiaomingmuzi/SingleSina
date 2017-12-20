package com.lixm.singlesina.glide;

import android.support.annotation.Nullable;

import com.lixm.singlesina.interfaces.ProgressListener;
import com.lixm.singlesina.utils.LogUtil;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * @author Lixm
 * @date 2017/12/19
 * @detail
 */

public class ProgressResponseBody extends ResponseBody {

    private static final String TAG = "ProgressResponseBody";
    private BufferedSource bufferedSource;
    private ResponseBody responseBody;
    private ProgressListener listener;

    public ProgressResponseBody(String url, ResponseBody responseBody) {
        this.responseBody = responseBody;
        listener = ProgressInterceptor.LISTENER_MAP.get(url);
    }

    @Nullable
    @Override
    public MediaType contentType() {
        return responseBody.contentType();
    }

    @Override
    public long contentLength() {
        return responseBody.contentLength();
    }

    @Override
    public BufferedSource source() {
        if (bufferedSource == null)
            bufferedSource = Okio.buffer(new ProgressSource(responseBody.source()));
        return bufferedSource;
    }

    private class ProgressSource extends ForwardingSource {
        long totalBytesRead = 0;
        int currentProgress;

        public ProgressSource(Source delegate) {
            super(delegate);
        }

        @Override
        public long read(Buffer sink, long byteCount) throws IOException {
            long bytesRead = super.read(sink, byteCount);
            long fullLength = responseBody.contentLength();
            if (bytesRead == -1) {
                totalBytesRead = fullLength;
            } else totalBytesRead += bytesRead;
            int progress = (int) (100f * totalBytesRead / fullLength);
            LogUtil.i("download progress is " + progress);
            if (listener != null && totalBytesRead == fullLength) {
                listener = null;
            }
            currentProgress=progress;
            return bytesRead;
        }
    }

}
