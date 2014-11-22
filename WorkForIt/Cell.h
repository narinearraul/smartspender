//
//  Cell.h
//  WorkForIt
//
//  Created by Nitesh on 11/22/14.
//  Copyright (c) 2014 Nitesh. All rights reserved.
//

#import <Foundation/Foundation.h>



@interface Cell : NSObject
@property (nonatomic)NSString *chore;
@property (nonatomic)int earned;



- (id)initWithChore:(NSString *)aChore
               earned:(int)aEarned;


@end
