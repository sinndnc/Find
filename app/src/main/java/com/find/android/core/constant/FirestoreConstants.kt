package com.find.android.core.constant


object FirestoreConstants {

    // --------------------- USER collection. -----------------------------------

    const val USER_COLLECTION = "users"

    const val USER_CHAT_COLLECTION = "chats"

    const val USER_UID = "uid"

    const val USER_DISPLAY_NAME = "displayName"

    const val USER_FRIENDS = "friends"

    const val USER_BLOCKS = "blockedUsers"

    const val USER_TOKEN = "token"

    const val USER_PICTURE = "picture"

    const val USER_PICTURE_FOLDER = "user_pictures"


    // --------------------- CHAT ROOM collection. -----------------------------------


    const val CHAT_ROOM_CHAT_UID = "chatUid"

    const val CHAT_ROOM_IMAGE = "chatImage"

    const val CHAT_ROOM_NAME = "chatName"

    const val CHAT_ROOM_MEMBERS = "members"

    const val CHAT_ROOM_MESSAGES = "messages"

    const val CHAT_ROOM_TYPE = "chatType"

    const val CHAT_ROOM_IS_ARCHIVED = "isArchived"

    const val CHAT_ROOM_IS_BLOCKED = "isBlocked"

    const val CHAT_ROOM_ADMIN = "admin"

    const val CHAT_ROOM_LAST_MESSAGE_DATE = "lastMessageDate"

    const val CHAT_ROOM_LAST_MESSAGE_TEXT = "lastMessageText"

    // --------------------- MESSAGE SUB-COLLECTION collection. -----------------------------------


    const val MESSAGE_UID = "messageUid"

    const val MESSAGE_TEXT = "messageText"

    const val MESSAGE_TIME = "sendTime"

    const val MESSAGE_SENDER_UID = "senderUid"

    const val MESSAGE_SENDER_NAME = "senderName"

    const val MESSAGE_DELETED = "deleted"
}
