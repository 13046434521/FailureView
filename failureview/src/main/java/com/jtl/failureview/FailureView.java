package com.jtl.failureview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * @作者JTL.
 * @日期2018/4/19.
 * @说明：加载失败View
 */

public class FailureView extends FrameLayout {
    public static final int IMAGE_HIDE = -1;

    private ImageView ivFailure;
    private TextView tvFailure;
    private Button btnFailure;
    private ProgressBar loadingBar;
    private LinearLayout containerLayout;

    public FailureView(@NonNull Context context) {
        this(context, null);
    }

    public FailureView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FailureView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.onCreate(context);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.failureView);
        String content = typedArray.getString(R.styleable.failureView_failureContent);
        String btnText = typedArray.getString(R.styleable.failureView_failureBtn);
        Drawable src = typedArray.getDrawable(R.styleable.failureView_failureSrc);
        boolean lodingVisible = typedArray.getBoolean(R.styleable.failureView_loadingVisible, false);
        typedArray.recycle();

        this.init(content, btnText, src, lodingVisible);
    }

    private void onCreate(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_failure, this);

        ivFailure = findViewById(R.id.iv_failure_content);
        tvFailure = findViewById(R.id.tv_failure_content);
        btnFailure = findViewById(R.id.failure_btn);
        loadingBar = findViewById(R.id.progressBar_failure_loading);
        containerLayout = findViewById(R.id.layout_failure_container);
    }

    private void init(String content, String btnText, Drawable source, boolean isVisible) {
        if (!TextUtils.isEmpty(content)) {
            tvFailure.setText(content);
        }
        if (!TextUtils.isEmpty(btnText)) {
            btnFailure.setText(btnText);
        }
        if (source != null) {
            ivFailure.setImageDrawable(source);
        }

        setLoadingShowing(isVisible);
    }

    public void show() {
        this.setVisibility(VISIBLE);
    }

    public void hide() {
        this.setVisibility(GONE);
    }

    public void setFailureImage(@DrawableRes int resource) {
        if (IMAGE_HIDE == resource) {
            ivFailure.setVisibility(GONE);
        } else {
            ivFailure.setVisibility(VISIBLE);
            ivFailure.setImageResource(resource);
        }
    }

    public void setContent(String content) {
        tvFailure.setText(content);
    }

    public void setBtnContent(String content) {
        btnFailure.setText(content);
    }

    public void setOnClick(OnClickListener onClickListener) {
        btnFailure.setOnClickListener(onClickListener);
    }

    public void setLoadingShowing(boolean loading) {
        if (loading) {
            loadingBar.setVisibility(VISIBLE);
            containerLayout.setVisibility(GONE);
        } else {
            loadingBar.setVisibility(GONE);
            containerLayout.setVisibility(VISIBLE);
        }
    }
}
