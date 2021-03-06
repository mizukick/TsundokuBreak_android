package com.mizukikubota.tsundokubreak.domain.repository.searchBookInfo

import com.mizukikubota.tsundokubreak.domain.entity.bookInfo.TsundokuBook
import com.mizukikubota.tsundokubreak.domain.entity.common.Resource
import kotlinx.coroutines.flow.Flow

interface SearchBookInfoRepository {

    suspend fun getBookInfo(isbn: String?): Flow<Resource<TsundokuBook>>

    suspend fun addBookToTsundoku(
        tsundokuBook: TsundokuBook,
        callback: () -> Unit,
        fallback: (Throwable) -> Unit
    )
}
