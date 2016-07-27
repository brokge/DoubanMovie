package com.udaye.movie.data.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.annotation.Nullable;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 创建 内容提供者
 * <p/>
 * 尽管您必须实现这些方法，但您的代码只需返回要求的数据类型，无需执行任何其他操作。
 * 例如，您可能想防止其他应用向某些表插入数据。 要实现此目的，您可以忽略 insert() 调用并返回 0
 * Created on 16/7/5.
 */
public class MovieContentProvider extends ContentProvider {

    private static final String TYPE_CURSOR_ITEM = "vnd.android.cursor.item/";
    private static final String TYPE_CURSOR_DIR = "vnd.android.cursor.dir/";

    public static final String AUTHORITY = "cn.dxy.movie";
    public static final String CONTENT_URI_BASE = "content://" + AUTHORITY;

    public static final String PATH_CACHE = "journal";

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {


        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Nullable
    @Override
    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        UriMatcher uriMatcher = new UriMatcher(100);
        uriMatcher.addURI(AUTHORITY, PATH_CACHE, 100);
        int code = uriMatcher.match(uri);
        if (code == 100) {
            File file = new File(getContext().getExternalCacheDir(), "responses");
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null && files.length > 0) {
                    for (File f : files) {
                        if (f.getName().equals("journal")) {
                            return ParcelFileDescriptor.open(f, ParcelFileDescriptor.MODE_READ_ONLY);
                        }
                    }
                }
            }
        }
        return super.openFile(uri, mode);
    }
}
