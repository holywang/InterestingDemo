package com.holy.interestingdemo.funnywrite;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.holy.interestingdemo.R;
import com.holy.interestingdemo.designpattern.factorypattern.base.INovelDetail;
import com.holy.interestingdemo.designpattern.factorypattern.base.INovels;
import com.holy.interestingdemo.funnywrite.database.DatabaseConstant;
import com.holy.interestingdemo.funnywrite.database.DatabaseManager;
import com.holy.interestingdemo.funnywrite.database.DatabaseUtils;
import com.holy.interestingdemo.mainInfo.BaseActivity;
import com.holy.interestingdemo.utils.FileUtil;
import com.holy.interestingdemo.utils.L;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NovelWriteActivity extends BaseActivity implements View.OnClickListener {

    public static final String TAG = "NovelWriteActivity";

    private Toolbar toolbar;
    private FloatingActionButton fab;
    private TextView showSession, showContextNum;
    private EditText pageInput, contextInput;
    private Button addSessionBtn;

    private Intent data;

    private INovels novel;
    private INovelDetail currentDetail;
    private List<INovelDetail> novelContextList = new ArrayList<>();
    private int contextNum;
    private String action;
    private boolean ifNone;

    private String session, page, context;

    private boolean ifSaved;

    @Override
    public void toSetContentView() {
        setContentView(R.layout.activity_novel_write);
    }

    @Override
    public void initViews() {
        data = getIntent();
        toolbar = findViewById(R.id.toolbar);
        fab = findViewById(R.id.novel_write_save_fab);
        addSessionBtn = findViewById(R.id.novel_write_add_session);
        showSession = findViewById(R.id.novel_write_show_session);
        showContextNum = findViewById(R.id.novel_write_select_novel_text_size);
        pageInput = findViewById(R.id.novel_write_edit_page);
        contextInput = findViewById(R.id.novel_input_edit);
    }

    @Override
    public void setListener() {
        fab.setOnClickListener(view -> save());
        contextInput.addTextChangedListener(watcher);
        addSessionBtn.setOnClickListener(this);
    }

    @Override
    public void doSth() {
        toolbar.setTitle("新章节编辑");
        setSupportActionBar(toolbar);

        novel = (INovels) data.getSerializableExtra("novel");
        action = data.getStringExtra("action");
        ifNone = data.getBooleanExtra("ifNone",false);
        if(!ifNone){
            novelContextList = getData();
            if (novelContextList.size() != 0) {
                currentDetail = novelContextList.get(novelContextList.size() - 1);
            }
        }
        if (action.equals("update")) {
            forUpdate();
            return;
        }
        if (action.equals("add")) {
            if (novelContextList.size() != 0) {
                secondAdd();
            } else {
                firstAdd();
            }
        }


    }

    /**
     * 首次添加
     */
    private void firstAdd() {
        showSession.setText("第1章");
    }

    /**
     * 非首次添加
     */
    private void secondAdd() {
        showSession.setText("第" + currentDetail.getSession() + "章");
    }

    /**
     * 修改
     */
    private void forUpdate() {
        showSession.setText("第" + currentDetail.getSession() + "章");
        pageInput.setText(currentDetail.getPage());

        ReadFileThread readThead = new ReadFileThread(new File(currentDetail.getContext()));
        new Thread(readThead, "读出文件").start();
    }


    /**
     * 获取 该 小说的所有章节
     *
     * @return
     */
    private List<INovelDetail> getData() {
        DatabaseManager manager = new DatabaseManager(this);

        List<Map<String, String>> contextList
                = DatabaseUtils.getList(
                manager.queryById(
                        DatabaseConstant.NOVEL_CONTEXT_TABLE,
                        DatabaseConstant.NOVEL_CONTEXT_ARRAY[0],
                        new String[]{novel.getNovelId()}
                ),
                DatabaseConstant.NOVEL_CONTEXT_TABLE);
        List<INovelDetail> resultList = new ArrayList<>();
        for (int i = 0; i < contextList.size(); i++) {
            INovelDetail item = new INovelDetail();
            item.setNovelId(contextList.get(i).get(DatabaseConstant.NOVEL_CONTEXT_ARRAY[0]));
            item.setDetailId(contextList.get(i).get(DatabaseConstant.NOVEL_CONTEXT_ARRAY[1]));
            item.setSession(contextList.get(i).get(DatabaseConstant.NOVEL_CONTEXT_ARRAY[2]));
            item.setPage(contextList.get(i).get(DatabaseConstant.NOVEL_CONTEXT_ARRAY[3]));
            item.setContext(contextList.get(i).get(DatabaseConstant.NOVEL_CONTEXT_ARRAY[4]));
            resultList.add(item);
        }

        if (resultList == null) {
            return new ArrayList<>();
        }
        return resultList;
    }

    /**
     * 保存方法
     */
    private void save() {
        session = showSession.getText().toString();
        page = pageInput.getText().toString();
        context = contextInput.getText().toString();


        if (!ifSaved) {
            Snackbar.make(contextInput, "已经保存啦，请放心", Snackbar.LENGTH_LONG).show();
            return;
        }
        saveTextToFile();
    }

    /**
     * 检查文字输入是否超长
     *
     * @param count
     */
    private void checkContextNum(int count) {
        if (count >= 10000) {
            Snackbar.make(contextInput, "极限了，一小节最多就能输入10000字", Snackbar.LENGTH_LONG).show();
            return;
        }
        if (9990 < count) {
            showContextNum.setTextColor(Color.RED);
        }
    }

    /**
     * 把输入的东西放到File里储存
     *
     * @return
     */
    private String saveTextToFile() {

        File textFile;
        if (action.equals("add")) {
            textFile = FileUtil.createNovelFile(novel.getNovelName(), createNovelName());
        } else {
            textFile = new File(currentDetail.getContext());
        }
        WriteFileThread thread = new WriteFileThread(textFile);
        new Thread(thread, "写入文件").start();

        return textFile.getAbsolutePath();
    }

    /**
     * 生成小说文件的名称
     *
     * @return
     */
    private String createNovelName() {
        StringBuilder sb = new StringBuilder();
        int last = novelContextList.size() + 1;
        String session = showSession.getText().toString();
        sb.append(session);
        sb.append(last);
        sb.append("小节");
        return sb.toString();
    }

    /**
     * Context的输入监听
     */
    private TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            L.i(TAG, "字数" + count);
            contextNum = count;
            checkContextNum(count);
            ifSaved = false;
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        save();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

    }



    /**
     * 写入文件的线程
     */
    class WriteFileThread implements Runnable {

        private File file;

        WriteFileThread(File file) {
            this.file = file;
        }

        @Override
        public void run() {

        }
    }

    /**
     * 读文件的线程
     */
    class ReadFileThread implements Runnable {

        private File file;

        ReadFileThread(File file) {

        }

        @Override
        public void run() {

        }
    }
}
