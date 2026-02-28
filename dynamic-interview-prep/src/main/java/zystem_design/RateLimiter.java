package zystem_design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class RateLimiter {

}

class FixedWindowRateLimiter_Basic {

  class UserBucket {
    long startTime;
    int requestCount;
  }

  long windowSizeMS;
  int maxRequest;
  HashMap<String, UserBucket> userBucketMap = new HashMap<String, UserBucket>();

  FixedWindowRateLimiter_Basic(int maxWindowSize, int maxRequest) {
    this.maxRequest = maxRequest;
    this.windowSizeMS = maxWindowSize;
  }

  boolean shouldAllow(String user) {
    long curTime =  System.currentTimeMillis();
    UserBucket bucket = userBucketMap.getOrDefault(user, new UserBucket());

    if(curTime - bucket.startTime > windowSizeMS) {
      bucket.startTime = curTime;
      bucket.requestCount = 0;
    }

    if(bucket.requestCount < maxRequest) {
      bucket.requestCount++;
      userBucketMap.put(user, bucket);
      return true;
    }

    return false;
  }
}

/*
* upgrade to thread safe
*
* Class Bucket {
*   final Object lock = new Object();
* }
*
* Class RateLimiter {
*   boolean allowUser(String user) {
*     .
*     .
*     synchronized(bucket.lock) {
*       if(bucket.requestCount < maxRequests) {
*         same as above
*       }
*     .
*     .
*
* */

/*
* upgrade to sliding window version
* class Bucket {
*   Deque<Long> timestamps = new ArrayDeque<>();
*   final Object lock = new Object();
* }
*
* class RateLimiter
*   boolean shouldAllow(String user)
*     .
*     .
*     synchronized(bucket.lock)
*       while(!userBucket.queue.isEmpty() && currentTime - userBucket.queue.peekFirst() > maxWindowSize)
*         userBucket.queue.poll()
*
*       if userBucket.queue.size() < maxRequest
*         userBucket.queue.offer(currentTime)
*         return true
*       return false
*
* */

/*
* upgrade to token bucket implementation
*
* class UserBucket
*   long lastRefillTimeStamp;
*   double tokens;
*   int capacity;
*
* class TokenBucketRateLimiter
*    capacity;
*    refillPerMS;
*
*    boolean allowRequest(userId)
*       tokenToAdd = (currentTimeMs - userBucket.lastRefillTimeStampMS) * refillPerMS;
*       userBucket.tokens = Min(capacity, userBucekt.tokens + tokenToAdd);
*       userBucket.lastRefillTimeStamp = currentTime;
*
*       if(userBucket.tokens > 0)
*         userBucekt.tokens--;
*         return true;
*       return false;
*
* */



class RateLimiter_0 {
  final int MAX_QUEUE_SIZE;
  final int TIME_WINDOW;
  Queue<Integer> requestQueue;

  public RateLimiter_0(int n, int t) {
    MAX_QUEUE_SIZE = n;
    TIME_WINDOW = t;
    requestQueue = new LinkedList<>();
  }

  RateLimiter_0() {
    MAX_QUEUE_SIZE = 0;
    TIME_WINDOW = 0;
  }

  public boolean shouldAllow(int timestamp) {
    while(!requestQueue.isEmpty() && requestQueue.peek() < (timestamp - TIME_WINDOW + 1)) {
      requestQueue.poll();
    }
    if(requestQueue.size() < MAX_QUEUE_SIZE) {
      requestQueue.offer(timestamp);
      return true;
    }
    return false;
  }
}
