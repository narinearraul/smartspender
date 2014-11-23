//
//  ChoresViewController.m
//  WorkForIt
//
//  Created by Nitesh on 11/22/14.
//  Copyright (c) 2014 Nitesh. All rights reserved.
//

#import "ChoresViewController.h"
#import "TableViewCell.h"

#import "Cell.h"

@interface ChoresViewController ()
//@property (weak, nonatomic) IBOutlet UIImageView *topImage;
@property (weak, nonatomic) IBOutlet UITableView *tableView;




@property (nonatomic)NSArray *travelList;
@property (nonatomic)NSArray *timeList;
@property (nonatomic)NSArray *costList;
@property (nonatomic)NSArray *dateList;



@end

@implementation ChoresViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    self.travelList = [NSArray arrayWithObjects:@"Travel From Chicago to Montreal", @"Travel From Los Angeles to Chicago", @"Travel From San Diego to Los Angeles", @"Travel From San Francisco to San Diego", @"Travel From Portland to San Francisco", @"Travel From Seattle to Portland", @"Travel From Vancouver to Seattle", nil];
    self.timeList = [NSArray arrayWithObjects:@"2:00 pm", @"7:00 am", @"10:00 am", @"5:00 pm", @"8:45 am", @"12:00 pm", @"8:00 pm", nil];
    self.costList = [NSArray arrayWithObjects:@"$3.75", @"$7.25", @"$2.00", @"$3.50", @"$4.00", @"$3.00", @"$4.50", nil];
    self.dateList = [NSArray arrayWithObjects:@"July 10th, 2014",@"July 10th, 2014",@"July 10th, 2014",@"July 8th, 2014", @"July 8th, 2014",@"July 8th, 2014",@"July 7th, 2014", nil];
    
    self.navigationController.navigationBarHidden = YES;
   // self.topImage.backgroundColor = [UIColor colorWithRed:0 green:143.0/255.0 blue:255/255 alpha:1];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}
- (CGFloat)tableView:(UITableView *)tableView heightForRowAtIndexPath:(NSIndexPath *)indexPath
{
    return 85;
}
/*
- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *simpleTableIdentifier = @"TableCell";
    
    
    return cell;
}*/

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section
{
    return [self.travelList count];
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
{
    static NSString *simpleTableIdentifier = @"tableCell";
    
    TableViewCell *cell = (TableViewCell *)[tableView dequeueReusableCellWithIdentifier:simpleTableIdentifier];
    if (cell == nil)
    {
        NSArray *nib = [[NSBundle mainBundle] loadNibNamed:@"TableViewCell" owner:self options:nil];
        cell = [nib objectAtIndex:0];
    }
    
    cell.userInteractionEnabled = NO;
    
    NSLog(@"indexpath is %@", indexPath);

   /*
    cell.name.numberOfLines = 0;
    cell.name.font = [UIFont fontWithName:@"Neuton-Regular" size:18];
    cell.name.text = [self.travelList objectAtIndex:indexPath.row];
    
    cell.time.font = [UIFont boldSystemFontOfSize:10.0f];
    cell.time.alpha = .8;
    cell.time.text = [self.timeList objectAtIndex:indexPath.row];
    
    cell.date.alpha = .4;
    cell.date.font = [UIFont boldSystemFontOfSize:9.0f];
    cell.date.text = [self.dateList objectAtIndex:indexPath.row];
    
    cell.cost.textColor = [UIColor colorWithRed:0 green:143.0/255.0 blue:255/255 alpha:1];
    cell.cost.text = [self.costList objectAtIndex:indexPath.row];
    */
    
    return cell;
}

/*
 
 - (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath
 {
 static NSString *simpleTableIdentifier = @"TableCell";
 
 TableViewCell *cell = (TableViewCell *)[tableView dequeueReusableCellWithIdentifier:simpleTableIdentifier];
 if (cell == nil)
 {
 NSArray *nib = [[NSBundle mainBundle] loadNibNamed:@"TableViewCell" owner:self options:nil];
 cell = [nib objectAtIndex:0];
 }
 */

/*
- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath{
    static NSString *simpleTableIdentifier = @"TableCell";
    
    TableViewCell *cell = (TableViewCell *)[tableView dequeueReusableCellWithIdentifier:simpleTableIdentifier];
    if (cell == nil)
    {
        NSArray *nib = [[NSBundle mainBundle] loadNibNamed:@"TableViewCell" owner:self options:nil];
        cell = [nib objectAtIndex:0];
    }
    
    
    cell.userInteractionEnabled = YES;
    
    TableViewCell *tbc = [[TableViewCell alloc] init] ;
    
   // cell.chore.text = [self.travelList objectAtIndex:indexPath.row ];
  //  cell.earned.text = [self.costList objectAtIndex:indexPath.row];
     cell.earned.text = @"qwerqwe";
    cell.earned.text = @" sfdghaf";
    tbc.earned.text = @"qwerqwe";
    tbc.earned.text = @" sfdghaf";
    
    
   //
    NSLog(@"indexpath is %@", indexPath);
    //tbc.earned.text = [self.costList objectAtIndex:indexPath.row];
    //tbc.chore.text = [self.travelList objectAtIndex:indexPath.row ];
    
    
    //tbc.earned.text = (NSString *) earned;
    
   // cell.chore = chore;
   // cell.earned = earned;
    
    return cell;
}
*/
/*
- (Cell *)tableView: (NSString *)chore earned: (int)earned{
    
    
  
    
    
    
 //   Cell *cell = [Cell alloc] ;
    cell = [cell initWithChore:chore earned:earned];
    
    

    //createCell(cell);
    
    return cell;
}
 */


/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
