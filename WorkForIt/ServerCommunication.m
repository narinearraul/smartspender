//
//  ServerCommunication.m
//  WorkForIt
//
//  Created by Kevin Gu on 11/22/14.
//  Copyright (c) 2014 Nitesh. All rights reserved.
//

#import "ServerCommunication.h"
@interface ServerCommunication()
    @property (strong, nonatomic)NSDictionary* json;
@end
@implementation ServerCommunication
-(NSDictionary*) getJson
{
    return self.json;
}

-(void) sendToServer: (NSString*) urlString withJSON:(NSDictionary*) json
{
    NSURL* url = [NSURL URLWithString:urlString];
    [self postHttpRequest: url withJSON:json];
}
-(void) getJsonFromServer:(NSString *) urlString withBlock: (void(^)(id))block
{
    NSURL* url = [NSURL URLWithString:urlString];
    [self getHttpRequest:url withBlock:block];
}
//simple post request
-(void) postHttpRequest: (NSURL *)path withJSON:(NSDictionary*) json
{
    NSMutableURLRequest* request = [NSMutableURLRequest requestWithURL:path];
    request.HTTPMethod =  @"POST";
    
    [request addValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
     NSData* data = [NSJSONSerialization dataWithJSONObject:json options:0 error:NULL];
    request.HTTPBody = data;
    NSURLSessionConfiguration* config = [NSURLSessionConfiguration defaultSessionConfiguration];
    NSURLSession* session = [NSURLSession sessionWithConfiguration:config];
    
    NSURLSessionDataTask* dataTask = [session dataTaskWithRequest:request completionHandler:^(NSData *data, NSURLResponse *response, NSError *error) {
        if (!error) {
            
        }
    }];
    [dataTask resume];
}

-(void)sendChoresToServer:(NSString*) urlString withArray:(NSArray*) array
{
    NSURL* url = [NSURL URLWithString:urlString];
    [self postHttpRequest:url withArray:array];
}

//simple post request
-(void) postHttpRequest: (NSURL *)path withArray:(NSArray*) array
{
    NSMutableURLRequest* request = [NSMutableURLRequest requestWithURL:path];
    request.HTTPMethod =  @"POST";
    
    [request addValue:@"application/json" forHTTPHeaderField:@"Content-Type"];
    NSData* data = [NSJSONSerialization dataWithJSONObject:array options:0 error:NULL];
    request.HTTPBody = data;
    NSURLSessionConfiguration* config = [NSURLSessionConfiguration defaultSessionConfiguration];
    NSURLSession* session = [NSURLSession sessionWithConfiguration:config];
    
    NSURLSessionDataTask* dataTask = [session dataTaskWithRequest:request completionHandler:^(NSData *data, NSURLResponse *response, NSError *error) {
        if (!error) {
            
        }
    }];
    [dataTask resume];
}
//http get request
- (void)getHttpRequest: (NSURL *)path withBlock:(void (^)(id)) block
{
    NSLog(@"Send to server");
    
    NSMutableURLRequest* request = [NSMutableURLRequest requestWithURL:path];
    request.HTTPMethod = @"GET"; //2
    [request addValue:@"application/json" forHTTPHeaderField:@"Accept"];
    NSURLSessionConfiguration* config = [NSURLSessionConfiguration defaultSessionConfiguration]; //4
    NSURLSession* session = [NSURLSession sessionWithConfiguration:config];
    
    NSURLSessionDataTask* dataTask = [session dataTaskWithRequest:request completionHandler:^(NSData *data, NSURLResponse *response, NSError *error) { //5
        if (error == nil) {
            NSLog(@"send server: %@", data);
            [self fetchedData:data withBlock:block];
        }
        else
        {
            NSLog(@"%@",error);
            block(self);
        }
    }];
    [dataTask resume]; //8
}




//parse out the json data
- (void)fetchedData:(NSData *)responseData withBlock:(void (^)(id)) block{
    NSError* error;
    _json = [NSJSONSerialization
             JSONObjectWithData:responseData //1
             
             options:kNilOptions
             error:&error];
    block(self);
}


@end
